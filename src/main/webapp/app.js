Ext.application({
    appFolder : 'app',
    name : 'HO',
    controllers : ['Contact'],
    launch : function() {
        console.log('launched');
        Ext.create('Ext.container.Viewport', {
            layout : 'fit',
            items : [{
                title : 'Contacts',
                xtype : 'contactlist'
            }]
        }); 
    }
});