Ext.application({
    name: 'HelloExt',
    appFolder: 'app',
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype:'panel',
                    title: 'Clients',
                    html : 'List of clients will be shown here'
                }
            ]
        });
    }
});