trait BaseSoundPlayer {
  def play 
  def close 
  def pause 
  def stop 
  def resume 
}

// 8.1. Using a Trait as an Interface
class Mp3SoundPlayer extends BaseSoundPlayer {
  def play = {}
  def close = {}
  def pause = {}
  def stop = { }
  def resume = { }
}

