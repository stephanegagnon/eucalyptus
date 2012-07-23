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

package com.eucalyptus.auth.policy.key;

import java.util.Date;
import org.apache.log4j.Logger;
import net.sf.json.JSONException;
import com.eucalyptus.auth.Contract;
import com.eucalyptus.auth.policy.PolicySpec;
import com.eucalyptus.auth.policy.condition.ConditionOp;
import com.eucalyptus.auth.policy.condition.DateEquals;

@PolicyKey( Keys.EC2_EXPIRATIONTIME )
public class ExpirationTime extends ContractKey<Date> {

  private static final Logger LOG = Logger.getLogger( ExpirationTime.class );
  
  private static final String KEY = Keys.EC2_EXPIRATIONTIME;
  
  private static final String ACTION_RUNINSTANCES = PolicySpec.VENDOR_EC2 + ":" + PolicySpec.EC2_RUNINSTANCES;
  
  private static final long YEAR = 1000 * 60 * 60 * 24 * 365; // one year by default
  
  @Override
  public void validateConditionType( Class<? extends ConditionOp> conditionClass ) throws JSONException {
    if ( DateEquals.class != conditionClass ) {
      throw new JSONException( KEY + " is not allowed in condition " + conditionClass.getName( ) + ". DateEquals is required." );
    }
  }

  @Override
  public void validateValueType( String value ) throws JSONException {
    KeyUtils.validateDateValue( value, KEY );
  }

  @Override
  public Contract<Date> getContract( final String[] values ) {
    return new Contract<Date>( ) {
      @Override
      public Contract.Type getType( ) {
        return Contract.Type.EXPIRATION;
      }
      @Override
      public Date getValue( ) {
        return getExpiration( values[0] );
      }
    };
  }

  @Override
  public boolean canApply( String action, String resourceType ) {
    return ACTION_RUNINSTANCES.equals( action );
  }

  @Override
  public boolean isBetter( Contract<Date> current, Contract<Date> update ) {
    return update.getValue( ).after( current.getValue( ) );
  }
  
  private static Date getExpiration( String expiration ) {
    try {
      return Iso8601DateParser.parse( expiration );
    } catch ( Exception e ) {
      LOG.debug( e, e );
      return new Date( System.currentTimeMillis( ) + YEAR );
    }
  }
  
}
