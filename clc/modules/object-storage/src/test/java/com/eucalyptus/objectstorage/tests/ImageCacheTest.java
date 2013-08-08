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
 *
 * This file may incorporate work covered under the following copyright
 * and permission notice:
 *
 *   Software License Agreement (BSD License)
 *
 *   Copyright (c) 2008, Regents of the University of California
 *   All rights reserved.
 *
 *   Redistribution and use of this software in source and binary forms,
 *   with or without modification, are permitted provided that the
 *   following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *     Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer
 *     in the documentation and/or other materials provided with the
 *     distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *   "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *   LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 *   FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 *   COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 *   INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 *   BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 *   CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 *   LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 *   ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *   POSSIBILITY OF SUCH DAMAGE. USERS OF THIS SOFTWARE ACKNOWLEDGE
 *   THE POSSIBLE PRESENCE OF OTHER OPEN SOURCE LICENSED MATERIAL,
 *   COPYRIGHTED MATERIAL OR PATENTED MATERIAL IN THIS SOFTWARE,
 *   AND IF ANY SUCH MATERIAL IS DISCOVERED THE PARTY DISCOVERING
 *   IT MAY INFORM DR. RICH WOLSKI AT THE UNIVERSITY OF CALIFORNIA,
 *   SANTA BARBARA WHO WILL THEN ASCERTAIN THE MOST APPROPRIATE REMEDY,
 *   WHICH IN THE REGENTS' DISCRETION MAY INCLUDE, WITHOUT LIMITATION,
 *   REPLACEMENT OF THE CODE SO IDENTIFIED, LICENSING OF THE CODE SO
 *   IDENTIFIED, OR WITHDRAWAL OF THE CODE CAPABILITY TO THE EXTENT
 *   NEEDED TO COMPLY WITH ANY SUCH LICENSES OR RIGHTS.
 ************************************************************************/

package com.eucalyptus.objectstorage.tests;

import org.junit.Ignore;
import org.junit.Test;
import com.eucalyptus.objectstorage.WalrusControl;
import com.eucalyptus.objectstorage.msgs.CacheImageResponseType;
import com.eucalyptus.objectstorage.msgs.CacheImageType;
import com.eucalyptus.objectstorage.msgs.CheckImageType;
import com.eucalyptus.objectstorage.msgs.FlushCachedImageResponseType;
import com.eucalyptus.objectstorage.msgs.FlushCachedImageType;
import com.eucalyptus.objectstorage.msgs.GetDecryptedImageType;

@Ignore("Manual development test")
public class ImageCacheTest {

    @Test
    public void testGetImage() throws Exception {

		WalrusControl bukkit = new WalrusControl();
        String userId = "admin";
        String bucket = "halothar1221";
        String key = "ttylinux.img.manifest.xml";

        CheckImageType checkImageRequest = new CheckImageType();
        checkImageRequest.setBucket(bucket);
        checkImageRequest.setKey(key);
        checkImageRequest.setUserId(userId);
       // CheckImageResponseType checkImageResponse = bukkit.CheckImage(checkImageRequest);

       // System.out.println(checkImageResponse);

        CacheImageType cacheImageRequest = new CacheImageType();
        cacheImageRequest.setBucket(bucket);
        cacheImageRequest.setKey(key);
        cacheImageRequest.setUserId(userId);
        CacheImageResponseType cacheImageResponse = bukkit.CacheImage(cacheImageRequest);
        System.out.println(cacheImageResponse);

        GetDecryptedImageType getDecryptedImageRequest = new GetDecryptedImageType();
        getDecryptedImageRequest.setBucket(bucket);
        getDecryptedImageRequest.setUserId(userId);
        getDecryptedImageRequest.setKey(key);
//        GetDecryptedImageResponseType getDecryptedImageResponse = bukkit.GetDecryptedImage(getDecryptedImageRequest);
 //       System.out.println(getDecryptedImageResponse);

        FlushCachedImageType flushCachedImageRequest = new FlushCachedImageType();
        flushCachedImageRequest.setBucket(bucket);
        flushCachedImageRequest.setUserId(userId);
        flushCachedImageRequest.setKey(key);
        FlushCachedImageResponseType flushCachedImageResponse = bukkit.FlushCachedImage(flushCachedImageRequest);
        System.out.println(flushCachedImageResponse);

        while(true) {
            Thread.sleep(5000);
        }
    }

}