/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//collections/src/test/org/apache/commons/collections/TestArrayStack.java,v 1.10 2003/10/05 21:03:44 scolebourne Exp $
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.commons.collections;

import java.util.EmptyStackException;
import java.util.List;

import junit.framework.Test;

/**
 * Tests ArrayStack.
 * 
 * @version $Revision: 1.10 $ $Date: 2003/10/05 21:03:44 $
 * 
 * @author Craig McClanahan
 */
public class TestArrayStack extends TestArrayList {
    
    protected ArrayStack stack = null;

    public TestArrayStack(String testName) {
        super(testName);
    }

    public static Test suite() {
        return BulkTest.makeSuite(TestArrayStack.class);
    }

    public static void main(String args[]) {
        String[] testCaseName = { TestArrayStack.class.getName() };
        junit.textui.TestRunner.main(testCaseName);
    }

    public List makeEmptyList() {
        return new ArrayStack();
    }

    public void setUp() {
        stack = (ArrayStack) makeEmptyList();
        list = stack;
    }

    //-----------------------------------------------------------------------
    public void testNewStack() {

        assertTrue("New stack is empty", stack.empty());
        assertEquals("New stack has size zero", stack.size(), 0);

        try {
            stack.peek();
            fail("peek() should have thrown EmptyStackException");
        } catch (EmptyStackException e) {
            ; // Expected result
        }

        try {
            stack.pop();
            fail("pop() should have thrown EmptyStackException");
        } catch (EmptyStackException e) {
            ; // Expected result
        }

    }

    public void testPushPeekPop() {

        stack.push("First Item");
        assertTrue("Stack is not empty", !stack.empty());
        assertEquals("Stack size is one", stack.size(), 1);
        assertEquals("Top item is 'First Item'",
                     (String) stack.peek(), "First Item");
        assertEquals("Stack size is one", stack.size(), 1);

        stack.push("Second Item");
        assertEquals("Stack size is two", stack.size(), 2);
        assertEquals("Top item is 'Second Item'",
                     (String) stack.peek(), "Second Item");
        assertEquals("Stack size is two", stack.size(), 2);

        assertEquals("Popped item is 'Second Item'",
                     (String) stack.pop(), "Second Item");
        assertEquals("Top item is 'First Item'",
                     (String) stack.peek(), "First Item");
        assertEquals("Stack size is one", stack.size(), 1);

        assertEquals("Popped item is 'First Item'",
                     (String) stack.pop(), "First Item");
        assertEquals("Stack size is zero", stack.size(), 0);

    }

    public void testSearch() {

        stack.push("First Item");
        stack.push("Second Item");
        assertEquals("Top item is 'Second Item'",
                     stack.search("Second Item"), 1);
        assertEquals("Next Item is 'First Item'",
                     stack.search("First Item"), 2);
        assertEquals("Cannot find 'Missing Item'",
                     stack.search("Missing Item"), -1);

    }

}