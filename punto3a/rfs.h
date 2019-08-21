/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _RFS_H_RPCGEN
#define _RFS_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


typedef struct {
	u_int file_data_len;
	char *file_data_val;
} file_data;

struct open_record {
	char *file_name;
	int flags;
};
typedef struct open_record open_record;

struct read_record {
	int fd;
	int count;
};
typedef struct read_record read_record;

struct write_record {
	struct open_record archivo_origen;
	struct open_record archivo_destino;
};
typedef struct write_record write_record;

#define RFS 0x20000001
#define RFS_VERS_1 1

#if defined(__STDC__) || defined(__cplusplus)
#define RFS_OPEN 1
extern  int * rfs_open_1(open_record *, CLIENT *);
extern  int * rfs_open_1_svc(open_record *, struct svc_req *);
#define RFS_READ 2
extern  file_data * rfs_read_1(read_record *, CLIENT *);
extern  file_data * rfs_read_1_svc(read_record *, struct svc_req *);
#define RFS_CLOSE 3
extern  int * rfs_close_1(int *, CLIENT *);
extern  int * rfs_close_1_svc(int *, struct svc_req *);
#define RFS_WRITE 4
extern  int * rfs_write_1(write_record *, CLIENT *);
extern  int * rfs_write_1_svc(write_record *, struct svc_req *);
extern int rfs_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define RFS_OPEN 1
extern  int * rfs_open_1();
extern  int * rfs_open_1_svc();
#define RFS_READ 2
extern  file_data * rfs_read_1();
extern  file_data * rfs_read_1_svc();
#define RFS_CLOSE 3
extern  int * rfs_close_1();
extern  int * rfs_close_1_svc();
#define RFS_WRITE 4
extern  int * rfs_write_1();
extern  int * rfs_write_1_svc();
extern int rfs_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_file_data (XDR *, file_data*);
extern  bool_t xdr_open_record (XDR *, open_record*);
extern  bool_t xdr_read_record (XDR *, read_record*);
extern  bool_t xdr_write_record (XDR *, write_record*);

#else /* K&R C */
extern bool_t xdr_file_data ();
extern bool_t xdr_open_record ();
extern bool_t xdr_read_record ();
extern bool_t xdr_write_record ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_RFS_H_RPCGEN */