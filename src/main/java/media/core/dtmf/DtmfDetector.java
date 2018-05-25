/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2018, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package media.core.dtmf;

import media.core.spi.dtmf.DtmfDetectorListener;
import media.core.spi.listener.TooManyListenersException;
import media.core.spi.memory.Frame;

/**
 * Interface for DTMF detector component
 *
 * @author Vladimir Morosev (vladimir.morosev@telestax.com)
 */
public interface DtmfDetector extends media.core.spi.dtmf.DtmfDetector {

    /**
     * The method that detects DTMF digit in provided audio buffer. Detection
     * status is passed to the application layer through a listener pattern.
     *
     * @param data     buffer with samples
     * @param duration buffer duration 
     * @return Detected digit, null if nothing is detected
     */
    void detect(byte[] data, long duration);

    @Override
    int getInterdigitInterval();

    @Override
    int getVolume();

    @Override
    String getId();

    @Override
    String getName();

    @Override
    void reset();

    @Override
    void activate();

    @Override
    void deactivate();

    @Override
    void flushBuffer();

    @Override
    void clearDigits();

    @Override
    void addListener(DtmfDetectorListener listener) throws TooManyListenersException;

    @Override
    void removeListener(DtmfDetectorListener listener);

    void addListener(media.core.dtmf.DtmfDetectorListener listener) throws TooManyListenersException;

    void removeListener(media.core.dtmf.DtmfDetectorListener listener);

    @Override
    void clearAllListeners();

    @Override
    boolean isStarted();

    @Override
    long getPacketsReceived();

    @Override
    long getBytesReceived();

    @Override
    void perform(Frame frame);
}
