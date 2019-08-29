/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "rfs.h"
#include <fcntl.h>


void rfs_1(char *host, char *file_name){

    CLIENT *clnt; int *result_1;
    open_record rfs_open_1_arg;
    file_data *result_2;
    read_record rfs_read_1_arg;
    int *result_3;
    int rfs_close_1_arg;
    int fd, n;

    #ifndef DEBUG
        clnt = clnt_create (host, RFS, RFS_VERS_1, "udp"); if (clnt == NULL) {
        clnt_pcreateerror (host);
        exit (1);
    }
    #endif /* DEBUG */
   
    rfs_open_1_arg.file_name = file_name; /* define archivo a leer */
    rfs_open_1_arg.flags = O_RDWR;
    /* define permisos */
    result_1 = rfs_open_1(&rfs_open_1_arg, clnt);
   
    if (result_1 == (int *) NULL) {
        clnt_perror (clnt, "Fallo llamada open");
    }
    
    fd = *result_1;
    
    if (fd == -1) {
        printf("Error al abrir el archivo\n"); return; 
    }
    
    rfs_read_1_arg.fd = fd;
    rfs_read_1_arg.count = 20;


    do {
    result_2 = rfs_read_1(&rfs_read_1_arg, clnt);
    if (result_2 == (file_data *) NULL) {
        clnt_perror (clnt, "Fallo llamada read");
    }
    
    for (n=0; n < result_2->file_data_len; ++n)
        putchar(result_2->file_data_val[n]);
    } while (result_2->file_data_len == 20);


    putchar('\n');
    result_3 = rfs_close_1(&rfs_close_1_arg, clnt);
    
    if (result_3 == (int *) NULL) {
        clnt_perror (clnt, "fallo llamada close");
    }

    #ifndef DEBUG
        clnt_destroy (clnt);
    #endif /* DEBUG */
    
}

/**********************************************/

void rfs_2 (char *host, char*file_name, char*file_name_2){
	CLIENT *clnt; 
	write_record rfs_write;
	open_record rfs_open_1_arg;
	
	int *result_1;
	int *fd_local;
	int *fd_remoto;
	int fd_l, fd_r;

	#ifndef DEBUG
        clnt = clnt_create (host, RFS, RFS_VERS_1, "udp"); if (clnt == NULL) {
        clnt_pcreateerror (host);
        exit (1);
    	}
	#endif

	//Abro el archivo remoto
	rfs_open_1_arg.file_name = file_name_2;
    rfs_open_1_arg.flags = O_RDWR;
	fd_remoto = rfs_open_1(&rfs_open_1_arg, clnt);
	if (fd_remoto == (int *) NULL) {
        clnt_perror (clnt, "Fallo llamada open");
    }
	fd_r = *fd_remoto;
    if (fd_r == -1) {
        printf("Error al abrir el archivo\n"); return; 
    }


		//Envio datos al servidor
	rfs_write.fd = *fd_remoto;
	rfs_write.buf.file_data_len = 1024;
	int *result_4;


	int fd1;
	char buffer[1024];
	char * buf_aux[1024];
	int numbytes;
	fd1 = open(file_name, O_RDONLY);
	while ((numbytes = read(fd1, &buffer, sizeof(char))) > 0){
		strcat(buf_aux, &buffer);
	}
	close(fd1);
	rfs_write.buf.file_data_val = buf_aux;
	rfs_write_1(&rfs_write, clnt);

}


int main (int argc, char *argv[]){
    char *host;
    char *file_name;
	char *file_name_2;
	
    /* Se deben pasar nombre de host y de archivo => argc=3 */
    
    if (argc < 3) {
        printf ("usage: %s server_host filename\n", argv[0]);
        exit (1);
    }
    
    host = argv[1];/* nombre del host remoto */
    file_name = argv[2]; /* nombre del archivo a leer */
	file_name_2 = argv[3];
    
    //rfs_1 (host, file_name);
    rfs_2(host, file_name, file_name_2);
    exit (0);
}