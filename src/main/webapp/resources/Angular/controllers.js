
var itemModule = angular.module('itemModule', []);

itemModule.controller('itemCtrl', function ($scope, $http) {
   
    $scope.addItem = function () {

        
        catObj  = jQuery( "#catagoriesSelect option:selected" ).val()
       
        
        var itemObj = {
                "id":   1,
             "name":        $scope.name,
             "serialNo":    $scope.serialNo,
             "category":    catObj
        };
        
        var staticObj = {
             
            "id":   1,
             "name":        "Name",
             "serialNo":    "asdsdsNssus8",
             "category":    {
                        "id":1,
                        "description": "House",
                        "name": "Furniture"
             }
            
        }
       
      alert(JSON.stringify(itemObj));
      jQuery.ajax({
           
            contentType: 'application/json',
            dataType: "json",
            type: "post",
            url: '/OSProc/items/add',
            data: JSON.stringify(staticObj),
            success: function (data) {
                //alert(data) // change Bootstrap Alert
            },
            error: function(request, status, error) {
                alert(request.responseText);
             },
            complete:function(data){
               // alert(data);
                
             
                
            }
            
        });


    };


});
