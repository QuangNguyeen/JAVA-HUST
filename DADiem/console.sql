CREATE DATABASE DLDIEM;
USE DLDIEM;
CREATE TABLE tbHOCVIEN (
  MAHV VARCHAR(10) PRIMARY KEY ,
  HOTEN VARCHAR(100),
  LOP VARCHAR(10),
  DIEM DOUBLE
);

INSERT INTO tbHOCVIEN VALUES
('D1154', 'NGUYEN VAN QUANG', '64KTPM2', 9.5),
('E2251', 'TRAN MAI PHUONG', '64LGT1', 10),
('M2354', 'CAO HIEN HOA', '64CNTT3', 9.5);

SELECT * FROM tbHOCVIEN;