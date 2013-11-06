Ext.define('HO.view.client.List', {
    extend : 'Ext.grid.Panel',
    alias : 'widget.clientlist',

    title : 'All Clients',
    store : 'Client',
    initComponent : function() {

        this.columns = [{
            header : 'Name',
            dataIndex : 'name',
            flex : 1
        }, {
            header : 'Email',
            dataIndex : 'email',
            flex : 1
        }];

        this.callParent(arguments);
    }
}); 