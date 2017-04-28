var viewTags = $('.bit-view'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiSchoolName = $('#fi-school-name'),
    fiWorking = $('#fi-working');

viewTags.css('display', 'none')

$('#add-btn').click(function() {
  $.post('add.json', {
    'email': fiEmail.val(),
    'name': fiName.val(),
    'tel': fiTel.val(),
    'schoolName': fiSchoolName.val(),
    'working': (fiWorking.prop('checked') ? 'Y' : 'N')

  }, function(result) {
    location.href = 'index.html'

  }, 'json')
})
