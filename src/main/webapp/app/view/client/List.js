Ext.define('HO.view.client.List', {
    extend : 'Ext.grid.Panel',
    alias : 'widget.clientlist',
    onAddClick : function(a) {
        console.log('add ' + a);
    },
    dockedItems : [{
        xtype : 'toolbar',
        items : [{
            iconCls : 'icon-add',
            text : 'Add',
            scope : this,
            handler : this.onAddClick
        }, {
            iconCls : 'icon-delete',
            text : 'Delete',
            disabled : true,
            itemId : 'delete',
            scope : this,
            handler : this.onDeleteClick
        }]
    }, {
        weight : 2,
        xtype : 'toolbar',
        dock : 'bottom',
        items : [{
            xtype : 'tbtext',
            text : '<b>Config: </b>'
        }, '|', {
            text : 'autoSync',
            enableToggle : true,
            pressed : true,
            tooltip : 'When enabled, Store will execute Ajax requests as soon as a Record becomes dirty.',
            scope : this,
            toggleHandler : function(btn, pressed) {
                this.store.autoSync = pressed;
            }
        }, {
            text : 'batch',
            enableToggle : true,
            pressed : true,
            tooltip : 'When enabled, Store will batch all records for each type of CRUD verb into a single Ajax request.',
            scope : this,
            toggleHandler : function(btn, pressed) {
                this.store.getProxy().batchActions = pressed;
            }
        }, {
            text : 'writeAllFields',
            enableToggle : true,
            pressed : false,
            tooltip : 'When enabled, Writer will write *all* fields to the server -- not just those that changed.',
            scope : this,
            toggleHandler : function(btn, pressed) {
                this.store.getProxy().getWriter().writeAllFields = pressed;
            }
        }]
    }, {
        weight : 1,
        xtype : 'toolbar',
        dock : 'bottom',
        ui : 'footer',
        items : ['->', {
            iconCls : 'icon-save',
            text : 'Sync',
            scope : this,
            handler : this.onSync
        }]
    }],
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
