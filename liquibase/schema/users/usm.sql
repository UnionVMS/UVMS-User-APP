-- DROP USER USM;

CREATE USER USM_SANDBOX
  IDENTIFIED BY password
  DEFAULT TABLESPACE USERS
  TEMPORARY TABLESPACE TEMP
  PROFILE DEFAULT
  ACCOUNT UNLOCK;
  -- 1 Role for USM_SANDBOX
  GRANT RESOURCE TO USM_SANDBOX;
  ALTER USER USM DEFAULT ROLE ALL;
  -- 7 System Privileges for USM_SANDBOX
  GRANT DROP ANY SEQUENCE TO USM_SANDBOX;
  GRANT CREATE SEQUENCE TO USM_SANDBOX;
  GRANT CREATE VIEW TO USM_SANDBOX;
  GRANT CREATE ANY SYNONYM TO USM_SANDBOX;
  GRANT UNLIMITED TABLESPACE TO USM_SANDBOX;
  GRANT CREATE ANY SEQUENCE TO USM_SANDBOX;
  GRANT CREATE SESSION TO USM_SANDBOX;