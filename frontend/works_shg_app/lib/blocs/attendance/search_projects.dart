import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:works_shg_app/services/urls.dart';
import 'package:works_shg_app/utils/global_variables.dart';

import '../../data/remote_client.dart';
import '../../data/repositories/attendence_repository/attendence_register.dart';
import '../../models/attendance/attendance_registry_model.dart';

part 'search_projects.freezed.dart';

typedef AttendanceProjectsSearchEmitter
    = Emitter<AttendanceProjectsSearchState>;

class AttendanceProjectsSearchBloc
    extends Bloc<AttendanceProjectsSearchEvent, AttendanceProjectsSearchState> {
  AttendanceProjectsSearchBloc()
      : super(const AttendanceProjectsSearchState()) {
    on<SearchAttendanceProjectsEvent>(_onSearch);
  }

  FutureOr<void> _onSearch(AttendanceProjectsSearchEvent event,
      AttendanceProjectsSearchEmitter emit) async {
    Client client = Client();
    emit(state.copyWith(loading: true));

    AttendanceRegistersModel attendanceRegistersModel =
        await AttendanceRegisterRepository(client.init())
            .searchAttendanceProjects(
                url: Urls.attendanceRegisterServices.searchAttendanceRegister,
                queryParameters: {
          "tenantId": GlobalVariables.getTenantId().toString()
        });
    await Future.delayed(const Duration(seconds: 1));
    emit(state.copyWith(
        attendanceRegistersModel: attendanceRegistersModel, loading: false));
  }
}

@freezed
class AttendanceProjectsSearchEvent with _$AttendanceProjectsSearchEvent {
  const factory AttendanceProjectsSearchEvent.search() =
      SearchAttendanceProjectsEvent;
}

@freezed
class AttendanceProjectsSearchState with _$AttendanceProjectsSearchState {
  const AttendanceProjectsSearchState._();

  const factory AttendanceProjectsSearchState({
    @Default(false) bool loading,
    AttendanceRegistersModel? attendanceRegistersModel,
  }) = _AttendanceProjectsSearchState;
}