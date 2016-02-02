~function($) {
  $('#selectAll').click(function() {
    if($(this).is(':checked')) {
      $(":checkbox[name = 'subtasks']").prop('checked', true);
    } else {
      $(":checkbox[name = 'subtasks']").prop('checked', false);
    }
  });

  $(":checkbox[name = 'subtasks']").click(function() {
    if(!$(this).prop('checked')) {
      $('#selectAll').prop('checked', false);
    }
  })
}($);