package adt

import org.junit.Test
import org.junit.Assert._
import org.junit.Before

class TestArrayQueue {
  @Before def createQueue() = {
    
  }
  
  @Test def emptyOnCreate() = {
    val arrQueue = new ArrayQueue[Int]()
    assertTrue(arrQueue.isEmpty)
  }
  
  @Test def addOneToQueue() = {
    val arrQueue = new ArrayQueue[Int]()
    arrQueue.enqueue(1)
    assertFalse(arrQueue.isEmpty)
    assertEquals(1, arrQueue.peek)
    assertEquals(1, arrQueue.dequeue())
    assertTrue(arrQueue.isEmpty)
  }
  
  @Test def addRemoveAdd() = {
    val arrQueue = new ArrayQueue[Int]()
    val nums1 = Array(1,2,3)
    for (n <- nums1) arrQueue.enqueue(n)
    for (n <- nums1) assertEquals(n, arrQueue.dequeue())
    assertTrue(arrQueue.isEmpty)
    
    val nums2 = Array(5,8,4,2,2,3,5,7,8,5,3,2,3,4,54,5,6,5,4,3,4,6,6,4,4,3,2,3,5,4,4,89)
    for (n <- nums2) arrQueue.enqueue(n)
    for (n <- nums2) assertEquals(n, arrQueue.dequeue())
    assertTrue(arrQueue.isEmpty)
  }
}