import 'dart:async';

import 'package:flutter/services.dart';

class FlutterPaystoreClient {
  static const MethodChannel _channel =
      const MethodChannel('flutter_paystore_client');

  static Future<String> get startPaymentV2 async {
    final String payment = await _channel.invokeMethod('startPaymentV2');
    return payment;
  }
}
