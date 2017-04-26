// 학생 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const studentDao = require('../dao/student-dao')
const studentService = require('../service/student-service')

const router = express.Router()

router.get('/main.do', (request, response) => {
  response.render('student/index')
})

module.exports = router
