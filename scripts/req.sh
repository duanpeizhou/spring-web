#!/bin/sh 
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "name": "duanpeizhou",
  "localDateTime": "2018-06-02 12:12:12",
  "birthDay": "2018-06-02 13:13:13",
  "contact":["段培州","段培州qq"],
  "bigData":"big big data",
  "address": "beijing"
}' 'http://localhost:8080/hello/save'
