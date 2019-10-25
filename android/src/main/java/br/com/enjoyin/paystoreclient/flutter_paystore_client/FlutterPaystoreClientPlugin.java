package br.com.enjoyin.paystoreclient.flutter_paystore_client;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.phoebus.android.payments.api.ApplicationInfo;
import br.com.phoebus.android.payments.api.Credentials;
import br.com.phoebus.android.payments.api.ErrorData;
import br.com.phoebus.android.payments.api.PaymentClient;
import br.com.phoebus.android.payments.api.PaymentRequestV2;
import br.com.phoebus.android.payments.api.PaymentType;
import br.com.phoebus.android.payments.api.PaymentV2;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterPaystoreClientPlugin */
public class FlutterPaystoreClientPlugin implements MethodCallHandler {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_paystore_client");
    channel.setMethodCallHandler(new FlutterPaystoreClientPlugin());
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, final @NonNull Result result) {
    PaymentClient paymentClient = new PaymentClient();

    if (call.method.equals("startPaymentV2")) {
      PaymentRequestV2 paymentRequest = new PaymentRequestV2();

      @NonNull
      String applicationId = Objects.requireNonNull(call.argument("applicationId"));
      @NonNull
      String token = Objects.requireNonNull(call.argument("token"));
      @NonNull
      int value = Integer.parseInt(Objects.requireNonNull(call.argument("value")));
      @NonNull
      String appVersion = Objects.requireNonNull(call.argument("appVersion"));
      @NonNull
      String transactionId = Objects.requireNonNull(call.argument("transactionId"));
      @Nullable
      List paymentTypes = new ArrayList(Objects.requireNonNull(call.argument("paymentTypes")));

      ApplicationInfo appInfo = new ApplicationInfo();
      Credentials credentials = new Credentials();
      credentials.setApplicationId(applicationId);
      credentials.setSecretToken(token);
      appInfo.setCredentials(credentials);
      appInfo.setSoftwareVersion(appVersion);

      paymentRequest.setValue(new BigDecimal(value));
      paymentRequest.setAppTransactionId(transactionId);
      paymentRequest.setAppInfo(appInfo);
      paymentRequest.setPaymentTypes(paymentTypes);
      PaymentClient.PaymentCallback<PaymentV2> paymentCallback = new PaymentClient.PaymentCallback<PaymentV2>() {
        @Override
        public void onSuccess(PaymentV2 paymentV2) {
          result.success(paymentV2);
        }

        @Override
        public void onError(ErrorData errorData) {
          result.error(errorData.getPaymentsResponseCode(), errorData.getResponseMessage(), errorData);
        }
      };

      try {
        paymentClient.startPaymentV2(paymentRequest, paymentCallback);
      } catch (Exception exception) {
        result.error(exception.getMessage(), exception.getLocalizedMessage(), exception);
      }

    } else {
      result.notImplemented();
    }
  }
}
