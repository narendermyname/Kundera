/*******************************************************************************
 * * Copyright 2012 Impetus Infotech.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 ******************************************************************************/
package com.impetus.kundera.lifecycle.states;

import com.impetus.kundera.lifecycle.EntityStateManagerImpl;

/**
 * @author amresh
 *
 */
public class ManagedState extends EntityState
{

    @Override
    public void persist(EntityStateManagerImpl context)
    {
        //Ignored, entity remains in the same state
        //TODO: Cascade persist operation for related entities for whom cascade=ALL or PERSIST
    }   

    @Override
    public void remove(EntityStateManagerImpl context)
    {
        context.setCurrentEntityState(new RemovedState());
        //TODO: Mark entity for removal in persistence context
        //TODO: Recurse remove operation for all related entities for whom cascade=ALL or REMOVE
    }

    @Override
    public void refresh(EntityStateManagerImpl context)
    {
        //TODO: Refresh entity state from the database
        //TODO: Cascade refresh operation for all related entities for whom cascade=ALL or REFRESH
    }

    @Override
    public void merge(EntityStateManagerImpl context)
    {
      //Ignored, entity remains in the same state
      //TODO: Cascade manage operation for all related entities for whom cascade=ALL or MERGE
    }
    
    @Override
    public void find(EntityStateManagerImpl context)
    {
    }

    @Override
    public void close(EntityStateManagerImpl context)
    {
        context.setCurrentEntityState(new DetachedState());
    }

    @Override
    public void clear(EntityStateManagerImpl context)
    {
    }

    @Override
    public void flush(EntityStateManagerImpl context)
    {        
        //TODO: Check for flush mode, if commit do nothing (state will be updated at commit)
        //else if AUTO, synchronize with DB
        
        //Entity state to remain as Managed
        
        //Cascade flush for all related entities for whom cascade=ALL or PERSIST
        
        
    }

    @Override
    public void lock(EntityStateManagerImpl context)
    {
    }

    @Override
    public void detach(EntityStateManagerImpl context)
    {
    }

    @Override
    public void commit(EntityStateManagerImpl context)
    {
        context.setCurrentEntityState(new DetachedState());
    }

    @Override
    public void rollback(EntityStateManagerImpl context)
    {
        //If persistence context is EXTENDED
        context.setCurrentEntityState(new TransientState());
        
        //If persistence context is TRANSACTIONAL
        //context.setCurrentEntityState(new DetachedState());
    }

    @Override
    public void getReference(EntityStateManagerImpl context)
    {
    }

    @Override
    public void contains(EntityStateManagerImpl context)
    {
    }   
    
    
}