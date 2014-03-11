Ext.define('HO.store.Contact', {
    extend : 'Ext.data.Store',
    model : 'HO.model.Contact',
    autoLoad : true,
    autoSync :true,
    proxy : {
        type: 'rest',
        
        // this is also important if you want to process one OR more records
        appendId: false,
        api : {
            read : 'rest/contact/list',
            create : 'rest/contact/add',
            update : 'rest/contact/update',
            destroy : 'rest/contact/delete'
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
