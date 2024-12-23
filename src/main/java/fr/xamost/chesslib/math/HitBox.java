package fr.xamost.chesslib.math;

public class HitBox
{
    public static boolean hitbox(Vector2D hit, Vector2D boxStart, int size)
    {
        return (hit.X() >= boxStart.X() && hit.Y() >= boxStart.X()) || (hit.X() <= boxStart.X() + size && hit.Y() <= boxStart.Y() + size);
    }
}
