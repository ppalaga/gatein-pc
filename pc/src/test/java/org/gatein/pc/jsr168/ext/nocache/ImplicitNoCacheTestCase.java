/******************************************************************************
 * JBoss, a division of Red Hat                                               *
 * Copyright 2006, Red Hat Middleware, LLC, and individual                    *
 * contributors as indicated by the @authors tag. See the                     *
 * copyright.txt in the distribution for a full listing of                    *
 * individual contributors.                                                   *
 *                                                                            *
 * This is free software; you can redistribute it and/or modify it            *
 * under the terms of the GNU Lesser General Public License as                *
 * published by the Free Software Foundation; either version 2.1 of           *
 * the License, or (at your option) any later version.                        *
 *                                                                            *
 * This software is distributed in the hope that it will be useful,           *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU           *
 * Lesser General Public License for more details.                            *
 *                                                                            *
 * You should have received a copy of the GNU Lesser General Public           *
 * License along with this software; if not, write to the Free                *
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA         *
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.                   *
 ******************************************************************************/
package org.gatein.pc.jsr168.ext.nocache;

import org.gatein.pc.framework.UTP3;
import org.gatein.pc.framework.UTP4;
import org.gatein.pc.unit.Assertion;
import org.gatein.pc.unit.PortletTestCase;
import org.gatein.pc.unit.annotations.TestCase;

/**
 * @author <a href="mailto:julien@jboss.org">Julien Viet</a>
 * @version $Revision: 1.1 $
 */
@TestCase({
   Assertion.EXT_NO_CACHE_1
   })
public class ImplicitNoCacheTestCase extends AbstractNoCacheTestCase
{
   public ImplicitNoCacheTestCase(PortletTestCase seq)
   {
      super(seq, UTP3.RENDER_JOIN_POINT, UTP3.ACTION_JOIN_POINT, UTP4.RENDER_JOIN_POINT);
   }
}