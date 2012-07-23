/*************************************************************************
 * Copyright 2009-2012 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/

//###########################################################
//# Eucalyptus Server Options
//###########################################################
//# Each option is listed with its default value indicated.  
//# Only key-value pair options are honored at this time
//###########################################################
//# TODO: port should be an option too.

//###########################################################
//# Web-Services Server and Client socket options
//###########################################################
//# - Socket options
//# SERVER_CHANNEL_REUSE_ADDRESS      = true;
//# SERVER_CHANNEL_NODELAY            = true;
//# CHANNEL_REUSE_ADDRESS             = true;
//# CHANNEL_KEEP_ALIVE                = true;
//# CHANNEL_NODELAY                   = true;


//###########################################################
//# Web-Services Server thread pool parameters
//###########################################################
//#
//# - Options controlling the thread pool which handles
//#   I/O on accepted client connections.
SERVER_POOL_MAX_THREADS           = 64;
//# SERVER_POOL_MAX_MEM_PER_CONN      = 1048576;
//# SERVER_POOL_TOTAL_MEM             = 100 * 1024 * 1024;
//# SERVER_POOL_TIMEOUT_MILLIS        = 500;
//#
//# - Options controlling the thread pool which handles
//#   socket.accept()
//# SERVER_BOSS_POOL_MAX_THREADS      = 40;
//# SERVER_BOSS_POOL_MAX_MEM_PER_CONN = 1048576;
//# SERVER_BOSS_POOL_TOTAL_MEM        = 100 * 1024 * 1024;
//# SERVER_BOSS_POOL_TIMEOUT_MILLIS   = 500;


//###########################################################
//# Connection and socket timeouts
//###########################################################
//# CLIENT_IDLE_TIMEOUT_SECS          = 4 * 60;
//# CLUSTER_IDLE_TIMEOUT_SECS         = 4 * 60;
//# CLUSTER_CONNECT_TIMEOUT_MILLIS    = 2000;
//# PIPELINE_READ_TIMEOUT_SECONDS     = 20;
//# PIPELINE_WRITE_TIMEOUT_SECONDS    = 20;

//###########################################################
//# Cluster Controller client thread pool parameters
//###########################################################
//# CLIENT_POOL_MAX_THREADS           = 40;
//# CLIENT_POOL_MAX_MEM_PER_CONN      = 1048576;
//# CLIENT_POOL_TOTAL_MEM             = 20 * 1024 * 1024;
//# CLIENT_POOL_TIMEOUT_MILLIS        = 500;
