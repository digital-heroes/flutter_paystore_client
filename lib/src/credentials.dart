import 'package:equatable/equatable.dart';

class Credentials extends Equatable {
  final String applicationId;
  final String token;

  const Credentials({ this.applicationId, this.token });

  @override
  List<Object> get props => [applicationId, token];
}