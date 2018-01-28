CREATE TABLE sms (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  phone_number varchar(255) not null,
  body varchar(255) not null,
  response varchar(255),
  request_number int,
  callback_url varchar(255)
);
