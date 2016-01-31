<div class="text-center">
    <h1>Currency Buying Rate Page</h1>

    <div class="currencyPlot">
        <select  class="currencySelect" ng-model="byCurrencyId">
            <option value="" selected disabled>Select Currency</option>
            <option ng-repeat="currency in currencyList" value="{{currency.currencyId}}">
                {{currency.currencyName}}
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