# flutter_paystore_client
Flutter plugin to use [PayStore API](https://github.com/paystore/paystore-api)

Using this API, you can make payments, confirm or cancel them (undo), and reverse them. These payments may be requested with predefined values ​​or open values ​​to be entered by the terminal operator, a list of types of payments (debit, demand credit, installment credit, etc.) allowed or without such restriction, as specified below. follow.

Even though this integration takes place via an API, the payments application may display information on the terminal interface, such as messages (e.g., "Insert or Pass Card"), or even request information from the operator (e.g., CVV). Therefore, while performing any operation, the application that requested the operation should not interact with the device interface until the operation is completed.

## Methods
  
| Signature | Description |
| -------- | -------- |
| [`void startPayment(PaymentRequest paymentRequest, PaymentCallback paymentCallback)`](#startpayment)| Performs the payment authorization process. (DEPRECATED: Use startPaymentV2) |
| [`void startPaymentV2(PaymentRequestV2 paymentRequest, PaymentCallback paymentCallback)`](#startpayment)| Performs the payment authorization process. |
| [`void confirmPayment(String paymentId, PaymentCallback paymentCallback)`](#confirmpayment) | Confirms a previously made payment authorization.   |
| [`void cancelPayment(String paymentId, PaymentCallback paymentCallback)`](#cancelpayment) | Undoes a payment authorization previously made. |
| [`void reversePayment(ReversePaymentRequest paymentRequest, PaymentCallback paymentCallback)`](#reversepayment) | Performs the process of chargeback.  |
| [`void cancelReversePayment(String paymentId, PaymentCallback paymentCallback)`](#cancelReversepayment) | Undoes a chargeback request.  |
| [`void setTheme(String theme, PaymentCallback paymentCallback)`](#setTheme) | Defines a theme for the Payments application.  |
