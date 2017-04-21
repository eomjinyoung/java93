// connection 객체를 준비
"use strict"
const mysql = require('mysql')
const con = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
con.connect()
