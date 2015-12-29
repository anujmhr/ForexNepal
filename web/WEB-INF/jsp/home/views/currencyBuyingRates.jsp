<div class="text-center">
    <h1>Currency Buying Rate Page</h1>

    <div class="currencyPlot">
        <select  class="currencySelect" ng-model="byCurrencyId">
            <option value="" selected disabled>Select Currency</option>
            <option ng-repeat="currency in currencyList" value="{{currency.currencyId}}">
                {{currency.currencyName}}
            <option>
        </select>
        <!--ng-change="populateTime(byDate)"--> 


        <select  class="currencyDate" ng-model="byDate" ng-change="populateTime(byDate)" >

            <option ng-repeat="date in dateList|orderBy:'-':true" value="{{date}}" selected>
                {{date}}
            <option>
        </select>

        <select  class="currencyTime" ng-model="byTime" >
            <option value="" disabled selected>Select Time</option>
            <option ng-repeat="time in timeList" value="{{time}}" >
                {{time}}
            <option>
        </select>



        <button class="btn btn-sm btn-default" ng-click="displayGraphByCurrency()"> Display</button>
    </div>

</div>