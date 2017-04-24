/* 주제: MySQL DBMS에 직접 접속하기 VIIII
=> DAO, Service를 nodeJS의 모듈로 만들기
 */
const {app, BrowserWindow} = require('electron')
const path = require('path')
const url = require('url')

const datasource = require('./util/datasource')
const connection = datasource.getConnection()

const studentDao = require('./dao/student-dao')
studentDao.setConnection(connection)

const memberDao = require('./dao/member-dao')
memberDao.setConnection(connection)

const teacherDao = require('./dao/teacher-dao')
teacherDao.setConnection(connection)

const managerDao = require('./dao/manager-dao')
managerDao.setConnection(connection)

const lectureDao = require('./dao/lecture-dao')
lectureDao.setConnection(connection)

const classroomDao = require('./dao/classroom-dao')
classroomDao.setConnection(connection)

const studentService = require('./service/student-service')
studentService.setMemberDao(memberDao)
studentService.setStudentDao(studentDao)

const teacherService = require('./service/teacher-service')
teacherService.setMemberDao(memberDao)
teacherService.setTeacherDao(teacherDao)

const managerService = require('./service/manager-service')
managerService.setManagerDao(managerDao)

const lectureService = require('./service/lecture-service')
lectureService.setLectureDao(lectureDao)

const classroomService = require('./service/classroom-service')
classroomService.setClassroomDao(classroomDao)

// global 빌트인 객체에 값을 보관하면,
// renderer 프로세스(웹 화면쪽)에서 꺼내 쓸 수 있다.
global.studentService = studentService
global.teacherService = teacherService
global.lectureService = lectureService
global.managerService = managerService
global.classroomService = classroomService

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, '../renderer/index.html'),
    slashes: true
  }))
  //win.webContents.openDevTools() // 웹브라우저의 개발도구창을 띄운다.

}


//
