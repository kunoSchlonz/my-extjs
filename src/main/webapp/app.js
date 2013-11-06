Ext.application({
    appFolder : 'app',
    name : 'HO',
    controllers : ['Client'],
    launch : function() {
        console.log('launched');
        Ext.create('Ext.container.Viewport', {
            layout : 'fit',
            items : [{
                title : 'Clients',
                xtype : 'clientlist'
            }]
        });
    }
});
