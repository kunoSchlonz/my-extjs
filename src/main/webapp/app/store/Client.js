Ext.define('HO.store.Client', {
    extend : 'Ext.data.Store',
    model : 'HO.model.Client',
    autoLoad : true,
    autoSync :true,
    proxy : {
        type : 'ajax',
        api : {
            read : 'rest/client/list',

            create : 'rest/client/add',
            update : 'rest/client/update',

            destroy : 'rest/client/delete'
        },
        reader : {
            type : 'json',
            successProperty : 'success',
            root : 'data',
            messageProperty : 'message'
        },
        writer : {
            type : 'json',
            writeAllFields : false,
            root : 'data'
        },
        listeners : {
            exception : function(proxy, response, operation) {
                Ext.MessageBox.show({
                    title : 'REMOTE EXCEPTION',
                    msg : operation.getError(),
                    icon : Ext.MessageBox.ERROR,
                    buttons : Ext.Msg.OK
                });
            }
        }
    }
});
