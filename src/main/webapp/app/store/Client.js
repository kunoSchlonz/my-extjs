Ext.define('HO.store.Client', {
    extend : 'Ext.data.Store',
    model : 'HO.model.Client',
    autoLoad : true,
    autoSync :true,
    proxy : {
        type: 'rest',
        
        // this is also important if you want to process one OR more records
        appendId: false,
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
            
            /* this is very important so every request is sended in brackets */
            allowSingle : false,
            writeAllFields : false
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
