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
package org.gatein.pc.impl.jsr168.api;

import org.gatein.pc.api.invocation.ResourceInvocation;
import org.gatein.pc.api.invocation.response.ContentResponse;
import org.gatein.pc.api.invocation.response.ResponseProperties;
import org.gatein.pc.api.cache.CacheLevel;
import org.gatein.pc.api.cache.CacheControl;

import javax.portlet.ResourceResponse;
import javax.portlet.PortletURL;
import java.util.Locale;
import java.util.Map;

/**
 * @author <a href="mailto:julien@jboss.org">Julien Viet</a>
 * @version $Revision: 630 $
 */
public class ResourceResponseImpl extends MimeResponseImpl implements ResourceResponse
{

   /** . */
   private final CacheLevel cacheability;

   public ResourceResponseImpl(ResourceInvocation invocation, PortletRequestImpl preq)
   {
      super(invocation, preq);

      //
      this.cacheability = invocation.getCacheLevel();
   }

   public void setLocale(Locale locale)
   {
      throw new UnsupportedOperationException();
   }

   public void setCharacterEncoding(String s)
   {
      throw new UnsupportedOperationException();
   }

   public void setContentLength(int i)
   {
      throw new UnsupportedOperationException();
   }

   public PortletURL createActionURL()
   {
      if (cacheability != CacheLevel.PAGE)
      {
         throw new IllegalStateException("Cannot create action URL because the current cache level " + cacheability +
            " is not " + CacheLevel.PAGE);
      }

      //
      return super.createActionURL();
   }

   public PortletURL createRenderURL()
   {
      if (cacheability != CacheLevel.PAGE)
      {
         throw new IllegalStateException("Cannot create render URL because the current cache level " + cacheability +
            " is not " + CacheLevel.PAGE);
      }

      //
      return super.createRenderURL();
   }

   protected ContentResponse createMarkupResponse(ResponseProperties properties, Map<String, Object> attributeMap, String contentType, byte[] bytes, String chars, CacheControl cacheControl)
   {
      return new ContentResponse(
         properties,
         attributeMap,
         contentType,
         bytes,
         chars,
         cacheControl);
   }
}