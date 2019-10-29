import 'package:flutter_paystore_client/models/models.dart';
import 'package:meta/meta.dart';
import 'package:equatable/equatable.dart';

class ApplicationInfo extends Equatable {
  final Credentials credentials;
  final String softwareVersion;

  const ApplicationInfo({ @required this.credentials, @required  this.softwareVersion });

  @override
  List<Object> get props => [credentials, softwareVersion];
}