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

package com.eucalyptus.auth.util;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import com.eucalyptus.crypto.util.B64;
import com.eucalyptus.crypto.util.PEMFiles;

public class X509CertHelper {
  
  public static String fromCertificate( X509Certificate x509 ) {
    return B64.url.encString( PEMFiles.getBytes( x509 ) );
  }
  
  public static X509Certificate toCertificate( String x509PemString ) {
    return PEMFiles.getCert( B64.url.dec( x509PemString ) );
  }
  
  public static String certificateToPem( X509Certificate x509 ) {
    try {
      return new String( PEMFiles.getBytes( x509 ), "UTF-8" );
    } catch ( UnsupportedEncodingException e ) {
      return new String( PEMFiles.getBytes( x509 ) );
    }
  }
  
  public static X509Certificate pemToCertificate( String pem ) {
    try {
      return PEMFiles.getCert( pem.getBytes( "UTF-8" ) );
    } catch ( UnsupportedEncodingException e ) {
      return PEMFiles.getCert( pem.getBytes( ) );
    }
  }
  
  public static String privateKeyToPem( PrivateKey pk ) {
    try {
      return new String( PEMFiles.getBytes( pk ), "UTF-8" );
    } catch ( UnsupportedEncodingException e ) {
      return new String( PEMFiles.getBytes( pk ) );
    }
  }
  
}
