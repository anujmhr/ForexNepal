<div class="jumbotron text-center">
    <h1>Bank Buying Rate Page</h1>

    <p>{{ message}}</p>


    <div class="bankPlot">
        <select  class="bankSelect" ng-model="byBankId">
            <option value="" selected disabled>Select bank</option>
            <option ng-repeat="bank in bankList" value="{{bank.bankId}}">
                {{bank.bankName}}
            <option>
        </select>

        <select  class="currencyDate" ng-change="populateTime(byDate)"  ng-model="byDate"  >
            <option value="" selected >Select Date</option>
            <option ng-repeat="date in dateList|orderBy:'+':true" value="{{date}}">
                {{date}}
            <option>
        </select>

        <select  class="currencyTime" ng-model="byTime" >
            <option value=""  selected>Select Time</option>
            <option ng-repeat="time in timeList" value="{{time}}" >
                {{time}}
            <option>
        </select>



        <button class="btn btn-sm btn-default" ng-click="displayGraphByCurrency()"> Display</button>
    </div>
</div>
