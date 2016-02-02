/**
 * Created by wudongbo on 2015/12/24.
 */

function submitSectionForm(taskId,sectionId){
  if(sectionId){
    $('#sectionForm').attr('action','/tasks/' + taskId + '/sections/' + sectionId + '/subtasks/sequence');
  } else {
    $('#sectionForm').action = '/tasks/' + taskId + '/section_sequence';
  }
  $('#sectionForm').submit();
}