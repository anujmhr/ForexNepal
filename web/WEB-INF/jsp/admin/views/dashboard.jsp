
<div class="jumbotron text-center">
    <h2>Dashboard</h2>

    <!--<p>{{ message }}</p>-->
    <button class="btn btn-default" ng-click="scrapAll()">Scrap</button>

    <!--Current Date Time:<b> {{currentDateTime | date:'dd/MM/yyyy hh:mm:ss a'}}</b><br />-->  


    <h3>Schedule Scrap</h3>


    <div ng-controller="DateTimeController">
        <!--            <label>Date format: <input ng-model="format"></label> <hr/>-->
        Current time is: <span my-current-time="format"></span>

    </div>
    
    
    


</div>