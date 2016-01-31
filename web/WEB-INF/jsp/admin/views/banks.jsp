<div class="container-fluid text-center">
    <h2>Bank Details</h2>

    <button class="btn btn-sm btn-default pull-right" ng-click="toggleAddBankForm()"> <span class ="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Banks</button>
   <!--add form-->
    <div class="well" ng-show="addBank">
        <form class="form-horizontal" role="form" ng-submit="addNewBank()" >
            <div class="form-group">
                <label class="col-md-2 control-label">Bank Name</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="bankName"
                           ng-model="bank.bankName" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">Address</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="address"
                           ng-model="bank.address" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">Contacts</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="contactNo"
                           ng-model="bank.contactNo" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">Website</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="website"
                           ng-model="bank.website" />
                </div>
            </div>
            <div class="form-group">								
                <div>
                    <input type="submit" value="Submit" class="btn btn-primary"/>
                </div>
            </div>
        </form>
    </div>
    <!--end of add form-->
    
    <div id="searchBox">
        <span class="col-md-1" style="font-weight:bold">Search</span>
        <span class="col-md-3">
            <input type="text" class="form-control" ng-model="searchKeyword"/>
        </span>
    </div>
    <table class="table table-hover table-responsive table-striped">
        <tr>
            <th ng-click="orderByField='bankName'; reverseSort = !reverseSort">Bank Name
            </th>
            <th ng-click="orderByField='address'; reverseSort = !reverseSort">Address
            </th>
            <th ng-click="orderByField='contactNo'; reverseSort = !reverseSort">Contacts
            </th>
            <th ng-click="orderByField='website'; reverseSort = !reverseSort">Web-site
            </th>
            <th>Action
            </th>
        </tr>
        <tr ng-repeat="bank in banks|  filter: searchKeyword | orderBy:orderByField:reverseSort"  class="text-left">
            <td>{{bank.bankName}}
            </td>
            <td>{{bank.address}}
            </td>
            <td>{{bank.contactNo}}
            </td>
            <td>{{bank.website}}
            </td>
            <td>
                <button class="btn btn-sm btn-primary" ng-click="editBank(bank.bankId)"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
                <button class="btn btn-sm btn-danger" ng-click="removeBank(bank.bankId)"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>


            </td>
        </tr>
    </table>


</div>