import 'package:equatable/equatable.dart';
import 'package:flutter_paystore_client/models/models.dart';
import 'package:meta/meta.dart';

// TODO Implement payment types
class PaymentRequest extends Equatable {
  final double value;
  final int installments;
  final String appTransactionId;
  final bool showReceiptView;
  final ApplicationInfo applicationInfo;
  final String transactionId;
  final bool tokenizeCard;
  final String tokenizeEmail;
  final String tokenizeNationalDocument;

  const PaymentRequest({
    @required this.value,
    this.installments,
    @required this.appTransactionId,
    this.showReceiptView,
    @required this.applicationInfo,
    @required this.transactionId,
    this.tokenizeCard,
    this.tokenizeEmail,
    this.tokenizeNationalDocument,
  });

  @override
  List<Object> get props => [
    value,
    installments,
    appTransactionId,
    showReceiptView,
    transactionId,
    tokenizeCard,
    tokenizeEmail,
    tokenizeNationalDocument,
  ];
}