Ext.define('HO.view.client.List', {
    extend : 'Ext.grid.Panel',
    alias : 'widget.clientlist',
    dockedItems : [{
        xtype : 'toolbar',
        items : [{
            glyph: 'xf055@FontAwesome',
            text : 'Add',
            action : 'add'
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
            glyph: 'xf046@FontAwesome',
            tooltip : 'When enabled, Store will execute Ajax requests as soon as a Record becomes dirty.',
            scope : this,
            toggleHandler : function(btn, pressed) {
                if(pressed){
                    btn.setGlyph('xf046@FontAwesome');
                }else{
                    btn.setGlyph('xf096@FontAwesome');
                }
                var s = Ext.StoreMgr.get("Client");
                s.autoSync = pressed;
            }
        }, {
            text : 'batch',
            enableToggle : true,
            pressed : true,
            glyph: 'xf046@FontAwesome',
            tooltip : 'When enabled, Store will batch all records for each type of CRUD verb into a single Ajax request.',
            scope : this,
            toggleHandler : function(btn, pressed) {
                if(pressed){
                    btn.setGlyph('xf046@FontAwesome');
                }else{
                    btn.setGlyph('xf096@FontAwesome');
                }
                var s = Ext.StoreMgr.get("Client");

                s.getProxy().batchActions = pressed;
            }
        }, {
            text : 'writeAllFields',
            enableToggle : true,
            pressed : false,
            glyph: 'xf096@FontAwesome',
            tooltip : 'When enabled, Writer will write *all* fields to the server -- not just those that changed.',
            scope : this,
            toggleHandler : function(btn, pressed) {
                if(pressed){
                    btn.setGlyph('xf046@FontAwesome');
                }else{
                    btn.setGlyph('xf096@FontAwesome');
                }
                var s = Ext.StoreMgr.get("Client");
                s.getProxy().getWriter().writeAllFields = pressed;
            }
        }]
    }, {
        weight : 1,
        xtype : 'toolbar',
        dock : 'bottom',
        ui : 'footer',
        items : ['->', {
            glyph: 'xf0ee@FontAwesome',
            text : 'Sync',
            scale: 'large',
            scope : this,
            handler : function(){
                var s = Ext.StoreMgr.get("Client");
                s.sync();
                
            }
        }]
    }],
    title : 'All Clients',
    store : 'Client',
    initComponent : function() {

        this.columns = [
        {
            header:'id',
            dataIndex:'id',
            flex:1
        },
        {
            header : 'Name',
            dataIndex : 'shortName',
            flex : 1
        }, {
            header : 'Typ',
            dataIndex : 'clientType',
            flex : 1
        }];

        this.callParent(arguments);
    }
});
