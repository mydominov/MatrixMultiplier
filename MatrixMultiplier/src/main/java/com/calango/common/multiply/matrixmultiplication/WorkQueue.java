package com.calango.common.multiply.matrixmultiplication;

import java.util.LinkedList;

/**
 *
 * @author Calango
 */
public class WorkQueue {
    /**
     * 
     */
    private final int nThreads;
    /**
     * 
     */
    private final PoolWorker[] threads;
    /**
     * 
     */
    private final LinkedList<Runnable> task;
    /**
     * 
     */
    private static volatile boolean stopped = false;
    
    /**
     * @param nThreads number of threads
     */
    public WorkQueue(final int nThreads) {
        this.nThreads = nThreads;
        task = new LinkedList<>();
        threads = new PoolWorker[nThreads];
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    /**
     * @param r runnable
     */
    public final void execute(final Runnable r) {
        synchronized (task) {
            task.addLast(r);
            task.notify();
        }
    }

    /**
     * @return
     */
    public final synchronized boolean isAllWorkDone() {
        return task.isEmpty();
    }
    
    /**
     * 
     */
    public final synchronized void stop() {
        synchronized (task) {
            stopped = true;
            task.notifyAll();
        }
    }
    
    /**
     * @author calango
     *
     */
    private class PoolWorker extends Thread {
        @Override
        public void run() {
            Runnable r;
            while (!stopped) {
                synchronized (task) {
                    while (task.isEmpty()) {
                        try {
                            task.wait();
                        } catch (InterruptedException ignored) {
                            System.out.println("Waiting too long");
                        }
                    }
                    r = (Runnable) task.removeFirst();
                }
                try {
                    r.run();
                } catch (RuntimeException e) {
                    System.out.println("I've been waiting too long!");
                }
            }
        }
    }
}
