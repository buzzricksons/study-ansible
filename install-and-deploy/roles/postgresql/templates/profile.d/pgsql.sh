#!/bin/bash

export pghome=$HOME/pgsql
export PGDATA=$HOME/pgdata
export LD_LIBRARY_PATH=$pghome/lib:$LD_LIBRARY_PATH
#export PATH=$pghome/bin:$PATH
export PATH=$PATH:$pghome/bin
