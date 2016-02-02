/**
 * Created by wudongbo on 2015/9/15.
 */
$(document).ready(function () {
  if ($("#relatedTask").length > 0) {
    $('#relatedTask').change(function () {
      var taskId = $(this).val();
      $('#title').val('');
      $('#description').html('');
      
      if ($("#imageUrlImg").length > 0) {
        $('#imageUrlImg').attr("src", '');
      }
      if ($("#imageUrlId").length > 0) {
        $('#imageUrlId').val('');
      }
      if ($("#imageName").length > 0) {
        $('#imageName').val('');
      }
      
      if ($("#relatedSubTask").length > 0) {
        $('#relatedSubTask').empty();
      }
      if (taskId != '') {
        $.get('/discovery/discovery_task/' + taskId, function (data, status) {
          if ($("#relatedSubTask").length == 0) {
            $('#title').val(data.title);
            $('#description').html(data.digest);
          }
          
          if ($("#imageUrlImg").length > 0) {
            $('#imageUrlImg').attr("src", data.imageTMSUrl);
          }
          if ($("#imageUrlId").length > 0) {
            $('#imageUrlId').val(data.imageName);
          }
          if ($("#imageName").length > 0) {
            $('#imageName').val(data.imageName);
          }
        });
        
        if ($("#relatedSubTask").length > 0) {
          $.get('/discovery/discovery_task/' + taskId + '/discovery_subtask/', function (data, status) {
            $.each(data, function (i) {
              $('#relatedSubTask').append('<option value="' + data[i].id + '">' + data[i].title + '</option>');
            });
            
            if (data.length > 0) {
              $('#title').val(data[0].title);
              $('#description').html(data[0].description);
            }
          });
        }
      }

    });
  }
  
  if ($("#relatedSubTask").length > 0) {
    $('#relatedSubTask').change(function () {
      var subTaskId = $(this).val();
      $('#title').val('');
      $('#description').html('');
      if (subTaskId != '') {
        $.get('/discovery/discovery_subtask/' + subTaskId, function (data, status) {
          $('#title').val(data.title);
          $('#description').html(data.digest);
        });
      }
    });
  }
});