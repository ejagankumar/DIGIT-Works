import 'dart:async';

import "package:dio/dio.dart";
import 'package:works_shg_app/Env/app_config.dart';

import '../models/request_info/request_info_model.dart';

class Client {
  Dio init() {
    final Dio dio = Dio();
    dio.interceptors.add(ApiInterceptors());
    dio.options.baseUrl = apiBaseUrl;

    return dio;
  }
}

class ApiInterceptors extends Interceptor {
  dynamic request;

  @override
  Future<dynamic> onRequest(
    RequestOptions options,
    RequestInterceptorHandler handler,
  ) async {
    options.data = {
      ...options.data,
      "RequestInfo": {
        ...RequestInfoModel(
          apiId: options.extra['apiId'] ?? 'Rainmaker',
          ver: ".01",
          ts: "",
          action: options.extra['action'] ?? "_search",
          did: "1",
          key: "",
          msgId: options.extra['msgId'] ?? "20170310130900|en_IN",
          authToken: options.extra['accessToken'],
        ).toJson(),
        "userInfo": options.extra['userInfo']
      },
    };
    super.onRequest(options, handler);
  }

  @override
  void onError(DioError err, ErrorInterceptorHandler handler) async {
    // ignore: no-empty-block
    if (err.type == DioErrorType.response && err.response?.statusCode == 401) {
    } else {
      handler.next(err);
    }
  }

  @override
  Future<dynamic> onResponse(
    Response<dynamic> response,
    ResponseInterceptorHandler handler,
  ) async {
    return handler.next(response);
  }
}