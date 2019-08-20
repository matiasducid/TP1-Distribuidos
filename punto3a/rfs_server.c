/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "rfs.h"



int * rfs_open_1_svc(open_record *argp, struct svc_req *rqstp){
        static int result;  
        printf("llamada open\n");
        result = open(argp->file_name, argp->flags);
        return &result;
}


file_data * rfs_read_1_svc(read_record *argp, struct svc_req *rqstp){
    static file_data result;
    int n;
    printf("llamada read\n");
    result.file_data_val = (char *) malloc(argp->count);
    if (result.file_data_val == 0){
        result.file_data_len = 0;
    }        
    else{
        result.file_data_len = read(argp->fd, result.file_data_val, argp->count);
    }
    return &result;
}



int * rfs_close_1_svc(int *argp, struct svc_req *rqstp){
    static int result;
    printf("llamada close\n");
    result = close(*argp);
    return &result;
}
    

int * rfs_write_1_svc(write_record *argp, struct svc_req *rqstp){
	static int  result;
    file_data *result_2;

    int *fd_origen;
    int *fd_destino;
    int n;
    int close;
    read_record rfs_read;
    int rfs_close_1_arg;

    int * result_11;
    int tope_lectura = 20;


    /* Abro el archivo origen */ 
    fd_origen = rfs_open_1_svc(&(argp->archivo_origen), rqstp);
    
    /* parametros de lectura */
    rfs_read.fd = *fd_origen;
    rfs_read.count = tope_lectura; 

    /* Abro el destino */    
    FILE *out_file = fopen("/home/anele/Escritorio/vacio.txt", "w"); // write only 

    /* Leo y escribo */
    do {
        result_2 = rfs_read_1_svc(&rfs_read, rqstp);
        if (result_2 == (file_data *) NULL) {
            clnt_perror (rqstp, "Fallo llamada read");
        }
    
        for (n=0; n < result_2->file_data_len; ++n){
            fprintf(out_file, "%c", result_2->file_data_val[n]);
        }
    } while (result_2->file_data_len == tope_lectura);

    fclose(out_file);
    printf("llamada procedimiento escritura terminado\n");
    return &result;
}
