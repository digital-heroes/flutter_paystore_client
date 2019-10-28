import 'dart:async';

import 'package:flutter/services.dart';
import 'package:meta/meta.dart';

class FlutterPaystoreClient {
  static const MethodChannel _channel =
      const MethodChannel('flutter_paystore_client');

  static Future<String> startPaymentV2({
    @required String transactionId,
    @required int value,
    @required String appVersion,
    @required String applicationId,
    @required String token,
    @required List paymentTypes
  }) async {
    final String payment = await _channel.invokeMethod('startPaymentV2', <String, dynamic>{
      'transactionId': transactionId,
      'value': value,
      'appVersion': appVersion,
      'token': token,
      'applicationId': applicationId,
      'paymentTypes': paymentTypes,
    });
    return payment;
  }
}
