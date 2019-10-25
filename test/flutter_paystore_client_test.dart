import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_paystore_client/flutter_paystore_client.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_paystore_client');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterPaystoreClient.startPaymentV2, '42');
  });
}
