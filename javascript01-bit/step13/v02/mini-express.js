/* 미니 Express 만들기
*/

module.exports = function() {
  return {
    get() {
      console.log('get()...')
    },
    post() {
      console.log('post()...')
    }
  }
}
